import pandas as pd

dataTowrite={
"empid":[1,2,3,4],
"mimuid":[5,6,7,8],
}

framedata=pd.DataFrame(dataTowrite)

print(framedata)
writer=pd.ExcelWriter("Dummy.xlsx")

framedata.to_excel(writer,sheet_name='Sheet1')

writer.close