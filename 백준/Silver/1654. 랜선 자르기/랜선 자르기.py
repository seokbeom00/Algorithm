k, n = map(int, input().split())
line = []
for i in range(k):
    line.append(int(input()))
line.sort()
start = 1
end = max(line)

while start <= end:
  mid = (start+end)//2
  tmp = 0
  for li in line:
     tmp += li // mid
  if tmp >= n:
    start = mid+1
  else:
    end = mid - 1
print(end)
