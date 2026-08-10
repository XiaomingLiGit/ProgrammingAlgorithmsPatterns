import gurobipy as gp
from gurobipy import GRB

# ----------------------
# Data
# ----------------------

coins = [1, 2, 5]
amount = 11

n = len(coins)

# ----------------------
# Model
# ----------------------

model = gp.Model("CoinChange")

# Decision variables
x = model.addVars(
    n,
    vtype=GRB.INTEGER,
    lb=0,
    name="x"
)

# Objective
model.setObjective(
    gp.quicksum(x[i] for i in range(n)),
    GRB.MINIMIZE
)

# Amount constraint
model.addConstr(
    gp.quicksum(coins[i] * x[i] for i in range(n))
    == amount,
    name="Amount"
)

# Solve
model.optimize()

# ----------------------
# Results
# ----------------------

if model.Status == GRB.OPTIMAL:

    print("Minimum coins =", model.ObjVal)

    for i in range(n):
        if x[i].X > 0.5:
            print(
                f"Coin {coins[i]} : {int(x[i].X)}"
            )

else:
    print("No feasible solution")