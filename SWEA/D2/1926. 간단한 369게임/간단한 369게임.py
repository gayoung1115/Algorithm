for i in range(1, int(input()) + 1):
    if "3" in str(i) or "6" in str(i) or "9" in str(i):
        three = str(i).count("3")
        six = str(i).count("6")
        nine = str(i).count("9")
        result = three+six+nine
        print("-"*result, end=" ")
    else:
        print(i, end=" ")
