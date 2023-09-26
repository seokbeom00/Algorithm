string = list(input())
for i in range(0, len(string)):
    if string[i].isspace():
        string[i] = " "
    elif string[i].isdigit():
        string[i] = string[i]
    elif string[i].isupper():
        if ord(string[i]) + 13 > 90:
            string[i] = chr(ord(string[i]) + 13 - 26)
        else:
            string[i] = chr(ord(string[i]) + 13)
    elif string[i].islower():
        if ord(string[i]) + 13 > 122:
            string[i] = chr(ord(string[i]) + 13 - 26)
        else:
            string[i] = chr(ord(string[i]) + 13)


def listToString(str_list):
    result = ""
    for s in str_list:
        result += s
    return result


string = listToString(string)
print(string)
