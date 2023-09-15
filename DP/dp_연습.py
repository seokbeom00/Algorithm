import time

#top-down 방식
arr1 = [0 for i in range (40)]

def top_down(n):
    if n<2:
       arr1[n] = n
       return arr1[n]
    if arr1[n] > 0:
        return arr1[n]
    else:
        arr1[n] = top_down(n-1) + top_down(n-2)
        return arr1[n]
        
if __name__ == "__main__":
    start = time.time()
    print(top_down(30))
    end = time.time()
    print(end - start)