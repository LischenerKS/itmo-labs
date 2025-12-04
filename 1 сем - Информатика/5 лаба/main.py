import openpyxl
import polars as pl

def read_excel_data(file_path):
    wb = openpyxl.load_workbook(file_path, data_only=True)
    sheet = wb['Главная']

    data_dict = dict()
    
    data_dict["A"] = str(sheet['B1'].value)
    data_dict["C"] = str(sheet['B3'].value)
    
    for i in range(1, 13):
        data_dict[f"X{i}"] = str(sheet[f'B{5+2*(i-1)}'].value)
    
    COLUMNS = ["W", "X", "Y", "Z", "AA", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL"]
    
    for i in range(1, 13):
        bits = [str(sheet[f'{column}{5+2*(i-1)}'].value) for column in COLUMNS]
        data_dict[f"B{i}"] = "".join(bits)
    
    return data_dict

def create_polars_dataframe(data):
    df = pl.DataFrame({
    'key': list(data.keys()),
    'value': list(data.values())
})
    return df

def main():
    file_path = 'основное задание.xlsx'
    
    data_dict= read_excel_data(file_path)
    # print(data_dict)

    df = create_polars_dataframe(data_dict)
    
    with pl.Config(tbl_rows=-1):
        print(df)
    



if __name__ == "__main__":
    main()