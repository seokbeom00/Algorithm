import sys

input = sys.stdin.readline
n = int(input())
tree = {}
for i in range(n):
    root, left, right = map(str, input().split())
    tree[root] = [left, right]


def dfs1(key):
    print(key, end="")
    if tree[key][0] != ".":
        dfs1(tree[key][0])
    if tree[key][1] != ".":
        dfs1(tree[key][1])


def dfs2(key):
    if tree[key][0] != ".":
        dfs2(tree[key][0])
    print(key, end="")
    if tree[key][1] != ".":
        dfs2(tree[key][1])


def dfs3(key):
    if tree[key][0] != ".":
        dfs3(tree[key][0])
    if tree[key][1] != ".":
        dfs3(tree[key][1])
    print(key, end="")


dfs1("A")
print()
dfs2("A")
print()
dfs3("A")
print()
