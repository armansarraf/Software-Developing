# world_data.py
# Arman Sarraf
#
# A terminal-based application for computing and printing statistics based on given input
import numpy as np
import pandas as pd
import warnings

warnings.filterwarnings("ignore")


def stage_1(csv_file):
    """
    stage_1 function gets the data we have imported named csv_file, changes its first three columns to the order we want, sort the indexes, and then returns the sorted file.
    :param csv_file: The imported data
    :type csv_file: data frame
    :return: df_sorted
    :rtype: data frame
    """
    df = csv_file
    list_columns = list(df)  # Putting list of columns exist in our data to a variable named list_columns
    list_columns[0:3] = ['UN Region', 'UN Sub-Region',
                         'Country']  # Changing the order of first three columns in the order we want
    df = df[list_columns]  # Making the changes in our data
    df_sorted = df.set_index(['UN Region', 'UN Sub-Region',
                              'Country'])  # Defining indexes to be set in our data set, putting them in a new variable named df_sorted
    df_sorted = df_sorted.sort_index()  # Sorting the indexed data
    return df_sorted


def stage_2(read_file):
    """
    This function gets the imported data as input, prompt the user to enter a sub-region name, checks if the input exists in our 'UN sub-region' column.
    If yes, it returns the input value, if no, it raises a value error to ask for another sub-region name from user.
    :param read_file: imported data
    :type read_file: data frame
    :return: input_value
    :rtype: string
    """
    flag = True
    while flag:  # Using while loop and try except to get the correct data from user
        try:
            input_value = input("Please enter a sub-region :")  # Asking from user to input a sub-region name
            if len(read_file[
                       read_file['UN Sub-Region'] == input_value]):  # Check if input exists in UN Sub-Region column
                return input_value
                flag = False  # Exit the loop
            else:
                raise ValueError  # using a ValueError to tell the user that entered input is not correct and re-enter another value
        except ValueError:
            print('You must enter a valid UN Sub-Region.')


def find_null(sorted_data, un_name):
    """
    This function gets the data sorted in stage-1 and input_value which is the name of the sub-region. At first, it filters our data with the input sub-region name
    and keeps just the values regarding that sub-region index. It then checks if any cell in 'Sq Km' column has an empty value.
    If yes, it prints the information regarding that country, if no, it prints no missing Sq Km value. At the end, it returns the sorted filtered data set.
    :param sorted_data: sorted data in stage_1
    :type sorted_data: data frame
    :param un_name: the name of sub-region
    :type un_name: string
    :return: sorted filtered data(df)
    :rtype: data frame
    """
    df = sorted_data.filter(like=un_name, axis=0)  # Filtering sorted data with the input sub region name
    if df[
        'Sq Km'].isnull().values.any():  # Using a mask operation to check if any of the values in column 'Sq Km' is null or not.
        print("\nSq km measurements are missing for:")
        df_with_null_value = df[df['Sq Km'].isnull()]  # Determining the location of null value
        print(df_with_null_value['Sq Km'])  # Printing the row and information regarding the null value
    else:
        print("\nThere are no missing sq km values for this sub-region.")

    return df


def stage_4(our_data):
    """
    stage_4 function gets the returned value from find_null function which is sorted filtered data. It then adds two new columns named Delta-population and Density and prints the data.
    It then uses IndexSlicing to cut the columns from Plants to Mammals and prints them. And in the final step, it uses pandas computation to calculate the sum of chosen columns
    to subtract 'Sq Km' values by them for each row and prints them.
    :param our_data: sorted filtered data set
    :type our_data: data frame
    :return: none
    :rtype: none
    """
    our_data['Delta population'] = our_data['2020 Pop'] - our_data[
        '2000 Pop']  # Creating a new column named Delta population
    our_data = our_data.fillna(np.NaN)  # Filling the null values with Nan using numpy computation
    our_data['Density'] = our_data['2020 Pop'] / our_data['Sq Km']  # Creating a new column named Density
    print("\nCalculating change in population and latest density...")
    print(our_data)
    print("******************************************************************************")
    print(our_data)
    print("******************************************************************************")
    threaten_species = our_data.loc[
        pd.IndexSlice[:, 'Algeria'], pd.IndexSlice[:, :]]  # Using IndexSlice to get the columns from Plants to Mammals

    print(f"\nThe number of threaten species in each country of the sub-region: \n {threaten_species} ")
    print("******************************************************************************")
    x = our_data['Sq Km'] / our_data.iloc[:, 1:5].sum(
        axis=1)  # Using pandas computation to subtract 'Sq Km' values by sum of values from Plants to Mammals for each row
    print(f"\nThe calculated Sq Km area per number of threatened species in each country is:\n \n{x}")


def main():
    # Stage 1: Import data
    excel_file_address = r'Data.xlsx'  # Address of the data
    df = pd.read_excel(excel_file_address)  # Importing data
    sorted_file = stage_1(df)  # Calling stage_1() function

    print("ENSF 592 World Data")

    # Stage 2: Request user input
    desired_un = stage_2(df)
    # Stage 3: Find any missing sq km data values for the chosen sub-region
    usr_input_subregion_filtered = find_null(sorted_file, desired_un)
    # Stage 4: Calculations and dataset printing for the chosen sub-region
    stage_4(usr_input_subregion_filtered)


if __name__ == '__main__':
    main()
