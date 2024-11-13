def is_prime(n):
    if n == 1:
        return "It is a prime word."
    for i in range(2, n):
        if n % i == 0:
            return "It is not a prime word."
    return "It is a prime word."

s = 0
for i in input():
    if i.islower():
        s += ord(i) - 96
    else:
        s += ord(i) - 38
print(is_prime(s))