import gurobipy as gp
from gurobipy import GRB

# -------------------------
# Data
# -------------------------

weights = [2, 3, 4, 5]
values  = [3, 4, 5, 6]
capacity = 5

n = len(weights)

# -------------------------
# Model
# -------------------------

model = gp.Model("Knapsack")

# Decision variables
x = model.addVars(n, vtype=GRB.BINARY, name="x")

# Objective
model.setObjective(
    gp.quicksum(values[i] * x[i] for i in range(n)),
    GRB.MAXIMIZE
)

# Capacity constraint
model.addConstr(
    gp.quicksum(weights[i] * x[i] for i in range(n))
    <= capacity,
    name="Capacity"
)

# Solve
model.optimize()

# -------------------------
# Results
# -------------------------

print("\nOptimal Value:", model.objVal)

print("\nSelected Items")

for i in range(n):
    if x[i].X > 0.5:
        print(
            f"Item {i}: "
            f"weight={weights[i]}, "
            f"value={values[i]}"
        )