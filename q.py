from itertools import product

words = []
for i in range(1, 6):
    for j in [product(["A", "E", "I", "O", "U"], repeat=i)]:
        for k in list(j):
            words.append(k)
print(sorted(words)[5])
