import gurobipy as gp
from gurobipy import GRB

# --------------------------------------------------
# 1. Problem data
# --------------------------------------------------

TOTAL_M = 3
TOTAL_C = 3

# Possible boat passengers:
# (missionaries, cannibals)
moves = [
    (1, 0),   # 1 missionary
    (0, 1),   # 1 cannibal
    (2, 0),   # 2 missionaries
    (0, 2),   # 2 cannibals
    (1, 1)    # 1 missionary + 1 cannibal
]


# --------------------------------------------------
# 2. Check whether a state is valid
# --------------------------------------------------

def is_valid(m_left, c_left):

    # Number of people must be valid
    if m_left < 0 or m_left > TOTAL_M:
        return False

    if c_left < 0 or c_left > TOTAL_C:
        return False

    m_right = TOTAL_M - m_left
    c_right = TOTAL_C - c_left

    # Left bank safety
    if m_left > 0 and c_left > m_left:
        return False

    # Right bank safety
    if m_right > 0 and c_right > m_right:
        return False

    return True


# --------------------------------------------------
# 3. Generate valid states
# --------------------------------------------------

states = []

for m in range(TOTAL_M + 1):
    for c in range(TOTAL_C + 1):

        if is_valid(m, c):

            states.append((m, c, "L"))
            states.append((m, c, "R"))


start = (3, 3, "L")
goal = (0, 0, "R")


# --------------------------------------------------
# 4. Generate valid transitions (arcs)
# --------------------------------------------------

arcs = []

# Store the move associated with each arc
arc_move = {}

for state in states:

    m, c, boat = state

    for move_m, move_c in moves:

        if boat == "L":

            # Boat moves from left to right
            next_state = (
                m - move_m,
                c - move_c,
                "R"
            )

        else:

            # Boat moves from right to left
            next_state = (
                m + move_m,
                c + move_c,
                "L"
            )

        # Check whether the new state is valid
        if next_state in states:

            arcs.append((state, next_state))

            arc_move[(state, next_state)] = (
                move_m,
                move_c
            )


# --------------------------------------------------
# 5. Create optimization model
# --------------------------------------------------

model = gp.Model("Missionaries_Cannibals")

# Decision variable:
# x[i,j] = 1 if transition i -> j is selected
x = model.addVars(
    arcs,
    vtype=GRB.BINARY,
    name="x"
)


# --------------------------------------------------
# 6. Objective:
#    Minimize the total number of crossings
# --------------------------------------------------

model.setObjective(
    gp.quicksum(x[i, j] for i, j in arcs),
    GRB.MINIMIZE
)


# --------------------------------------------------
# 7. Flow conservation constraints
# --------------------------------------------------

for s in states:

    outgoing = gp.quicksum(
        x[i, j]
        for i, j in arcs
        if i == s
    )

    incoming = gp.quicksum(
        x[i, j]
        for i, j in arcs
        if j == s
    )

    if s == start:

        model.addConstr(
            outgoing - incoming == 1,
            name=f"start_{s}"
        )

    elif s == goal:

        model.addConstr(
            outgoing - incoming == -1,
            name=f"goal_{s}"
        )

    else:

        model.addConstr(
            outgoing - incoming == 0,
            name=f"flow_{s}"
        )


# --------------------------------------------------
# 8. Solve
# --------------------------------------------------

model.optimize()


# --------------------------------------------------
# 9. Print solution
# --------------------------------------------------

if model.status == GRB.OPTIMAL:

    print("\nMinimum number of crossings:",
          int(model.objVal))

    # Find selected arcs
    selected_arcs = [
        (i, j)
        for i, j in arcs
        if x[i, j].X > 0.5
    ]

    # Reconstruct path from start to goal
    current = start
    step = 1

    print("\nOptimal path:")
    print(current)

    while current != goal:

        for i, j in selected_arcs:

            if i == current:

                move_m, move_c = arc_move[(i, j)]

                direction = "->" if i[2] == "L" else "<-"

                print(
                    f"{step}. Move "
                    f"{move_m}M {move_c}C {direction}"
                )

                print(j)

                current = j
                step += 1
                break

else:
    print("No feasible solution found.")