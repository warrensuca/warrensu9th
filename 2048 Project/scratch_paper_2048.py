row = [4,2,2]
j = 0
count = 0
while j < len(row)-1:
    print(row[j],row[j-1], j)
    if row[j] == row[j + 1]:
        row[j + 1] += row[j]

        count += row[j + 1]
        row.pop(j)
        j += 1
    j += 1
print(row,count)