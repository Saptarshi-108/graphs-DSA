#Maximum Sub array (contiguous)

arr=[-2,-3,4,-1,-2,1,5,-3]
maximum=float('-inf')
sum=0
for i in range(len(arr)):
    sum=max(arr[i],arr[i]+sum)
    maximum=max(sum,maximum)
print(f"The maximum contiguous sub array is {maximum}.")



        