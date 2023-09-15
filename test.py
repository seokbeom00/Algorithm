import random
a = random.sample(range(1,1000), 10)
def bubble_sort(a):
    for i in range(len(a)):
        for j in range(len(a)-i):
            if j+1 == len(a)-i:
                break
            elif a[j] > a[j+1]:
                a[j], a[j+1] = a[j+1], a[j]
    print(a)

def assign2(string):
    char_list = [c for c in string if c.isalnum()]
    # print(char_list)

    char_count_dict = {c:char_list.count(c) for c in char_list}
    sorted_char_count_dict = sorted(char_count_dict.items(), key=lambda x: x[1], reverse=True)
    print(sorted_char_count_dict)

if __name__ == "__main__":
    s = """
    It is a multidisciplinary approach that combines principles and practices from the fields of mathematics, 
    statistics, artificial intelligence, and computer engineering to analyze large amounts of data."""
    assign2(s)
    