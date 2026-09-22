# Counting Landmasses

def countLandmasses(grid):
    rows = len(grid)
    cols = len(grid[0])

    def dfs(row, col):
        if row < 0 or row >= rows or col < 0 or col >= cols or grid[row][col] == "0":
            return

        grid[row][col] = "0"

        dfs(row + 1, col)
        dfs(row - 1, col)
        dfs(row, col + 1)
        dfs(row, col - 1)

    count = 0

    for row in range(rows):
        for col in range(cols):
            if grid[row][col] == "1":
                count += 1
                dfs(row, col)

    return count


rows = int(input("Enter number of rows: "))

grid = []

print("Enter the grid:")

for i in range(rows):
    grid.append(list(input().strip()))

print("Number of landmasses:", countLandmasses(grid))