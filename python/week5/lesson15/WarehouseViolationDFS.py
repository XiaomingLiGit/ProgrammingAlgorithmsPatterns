grid = [
    ['.', 'S', 'F', 'F', '.'],
    ['S', 'C', 'F', '.', '.'],
    ['.', 'C', 'S', '.', '.'],
    ['.', '.', '.', 'C', 'F'],
    ['.', '.', '.', 'F', 'F']
]

# grid = [
#         ['.','.','.','.'],
#         ['.','S','S','.'],
#         ['.','S','S','.'],
#         ['.','.','.','.']
#     ]


num_row = len(grid)
num_column = len(grid[0])

visited_matrix = [[False for _ in range(num_column)] for _ in range(num_row)]

# visited_matrix = [[False] * num_column] * num_row

violation_counter = 0


# apply DFS alg to find out clusters

def dfs(row, column, cluster):
    if row < 0 or row > num_row - 1 or column < 0 or column > num_column - 1 \
            or visited_matrix[row][column] or grid[row][column] == '.':
        return

    else:
        visited_matrix[row][column] = True
        cluster.append(grid[row][column])

        dfs(row, column + 1, cluster)  # right
        dfs(row + 1, column, cluster)  # down
        dfs(row, column - 1, cluster)  # left
        dfs(row - 1, column, cluster)  # up


'''try each cell'''
for i in range(num_row):
    for j in range(num_column):

        cluster = []

        dfs(i, j, cluster)

        chemical_counter = cluster.count('C')
        flammable_counter = cluster.count('F')

        # constraint 1: Chemical < 3
        # constraint 2: Flammable < 5
        # constraint 3: Chemical >= 1 and Flammable >= 1
        if (chemical_counter >= 3) or (flammable_counter >= 5) or (chemical_counter >= 1 and flammable_counter >= 1):
            violation_counter += 1

print(f'The number of violation is {violation_counter}')


