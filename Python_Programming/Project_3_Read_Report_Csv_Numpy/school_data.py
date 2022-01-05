# school_data.py
# Arman Sarraf
#
# A terminal-based application for computing and printing statistics based on given input
import pandas as pd
import numpy as np


def read_csv_file(csv_name):
    """
    This function uses Pandas to read the CSV file and keep it in data frame named df. It gets the address of file, read, extracts the high school data, and then returns the new_array
    :param csv_name: address of the file
    :type csv_name: str
    :return: new_array
    :rtype: numpy array
    """
    df = pd.read_csv(csv_name)  # Reading csv file with pandas
    new_array = df.values[:, 0:6]  # Please Note: Because our csv file has some general text information, we created a new array that does not have them (sub array)
    return new_array


def stage_one(np_array):
    """
    Taking np_array as input and Creating a 3D numpy array from the high school data
    :param np_array: Our all high school data
    :type np_array: Data Frame
    :return: none
    :rtype: none
    """
    df_values = np_array  # Creating a new numpy array from input value
    df_values = df_values[:, 3:6]  # Choosing 3 last columns to put into numpy array (sub array)
    df_values_reshaped = np.reshape(df_values, (8, 20, 3))  # Reshaping array to a 3-dimensional array and fill it with last three columns from high school data
    print("Shape of full data array:", np.shape(df_values_reshaped))  # Printing shape of numpy array
    print("Dimensions of full data array:", np.ndim(df_values_reshaped))  # Printing the dimensions of array


def stage_two(np_array):
    """
    In this function we get our stored data (np_array) and give the user the permission to input a school name or code, then we determine if the input value exists in our school name
    or school code. If not, we raise a Value Error to get the input again. Then, we create a new array from all data related to our input high school and return it.
    :param np_array: Our all high school data
    :type np_array: Data Frame
    :return: input_filtered_data (list of numpy array)
    :rtype: list
    """
    converted_array = np_array
    input_filtered_data = []
    flag = True
    while flag:  # Using while loop and try except to get the correct data from user
        try:
            input_value = input("Please enter the high school name or school code:")  # Asking from user to input school name or school code
            if input_value in converted_array[:, 1]:  # Check if input exists in high school name column
                input_filtered_data = converted_array[(converted_array[:, 1] == input_value)]  # If yes, then take all the rows and columns that are related to that school
                flag = False  # Exit the loop
            elif int(input_value) in converted_array[:, 2]:  # Check if input exists in high school code column
                input_filtered_data = converted_array[(converted_array[:, 2] == int(input_value))]  # If yes, then take all the rows and columns that are related to that school
                flag = False  # Exit the loop
            else:
                raise ValueError  # using a ValueError to tell the user that entered input is not correct and re-enter another value
        except ValueError:
            print('You must enter a valid school name or code.')

    return input_filtered_data


def school_stat(x_displayed):
    """
    In this method, we get the 2D array that we created in the previous step and after some processing
    and analyzing our data, we print the name, code, average of grades 10 to 12, ....
    :param x_displayed: Our selected high school data
    :type x_displayed: 2D numpy array
    :return: none
    :rtype: none
    """
    print("School Name:", x_displayed[0, 1]+',', "School Code", x_displayed[0, 2])  # Printing the name and code of the school
    mean_grade10 = x_displayed[:, 3].mean()  # Calculating average using numpy computation of column "Grade10"
    print("Mean Enrollment for Grade 10:", mean_grade10)  # Printing average of column "Grade10"
    mean_grade11 = x_displayed[:, 4].mean()  # Calculating average using numpy computation of column "Grade11"
    print("Mean Enrollment for Grade 11:", mean_grade11)  # Printing average of column "Grade12"
    mean_grade12 = x_displayed[:, 5].mean()  # Calculating average using numpy computation of column "Grade12"
    print("Mean Enrollment for Grade 12:", mean_grade12)  # Printing average of column "Grade12"
    highest_enrollment = x_displayed[:, -3::].max()  # Calculating the maximum value exists using numpy computation in grades 10 to 12 in the entire high school (sub array)
    print("Highest Enrollment for a Single Grade", highest_enrollment)  # Printing the maximum value exists in grades 10 to 12 in the entire high school
    lowes_enrollment = x_displayed[:, -3::].min()  # Calculating the minimum value exists using numpy computation in grades 10 to 12 in the entire high school (sub array)
    print("Lowest Enrollment for a Single Grade", lowes_enrollment)  # Printing the minimum value exists in grades 10 to 12 in the entire high school
    total_enrollment_years = {}  # Creating a Dictionary
    for ii in range(len(x_displayed)):  # Dictionary
        year = x_displayed[ii, 0]  # Choosing first column which is year
        if year in total_enrollment_years:  # Filling the dictionary by if condition with the years from 2013 to 2020
            total_enrollment_years[year] += x_displayed[ii, -3::].sum()  # Calculating the sum of all the grades in a specific year
        else:
            total_enrollment_years[year] = x_displayed[ii, -3::].sum()
    for year in total_enrollment_years:  # Using a for-loop to print the year and the sum of grades for that year
        print("Total Enrollment for year {} is {}".format(year, total_enrollment_years[year]))

    if x_displayed[:, -3::].max() <= 500:  # Using an if-condition to determine if any grade in three last column in the entire selected high school is more than 500
        print("No Enrollments Over 500")  # if no, this line will be printed
    else:
        sorted_x = np.sort(x_displayed[:, -3::])  # if yes, we sort our grades using numpy computation in order to be able to calculate the median. (sub array)
        over_500 = (sorted_x > 500)  # Creating a mask array of the values over 500
        print("For All Enrollments Over 500, The Median Value Was:", np.median(sorted_x[over_500]))  # Printing the median value of values over 500


def stage_three(np_array):
    """
    stage_three function does not rely on input value or any specific high school. it gets the entire read data and do some calculations on it.
    :param np_array: Our all high school data
    :type np_array: Data frame
    :return: none
    :rtype: none
    """
    my_array = np_array  # Creating a new numpy array from our high school data
    year_2013 = 2013
    year_2020 = 2020
    new_array_2013 = my_array[(my_array[:, 0] == year_2013)]  # Filtering our data which their year are 2013
    mean_2013 = new_array_2013[:, -3::].mean()  # Calculating average for all grades using numpy computation in 2013 (sub array)
    new_array_2020 = my_array[(my_array[:, 0] == year_2020)]  # Filtering our data which their year are 2020
    mean_2020 = new_array_2020[:, -3::].mean()  # Calculating average for all grades using numpy computation in 20202 (sub array)
    print("Mean Enrollment in 2013:", mean_2013)
    print("Mean Enrollment in 2020:", mean_2020)

    graduate_2020 = my_array[(my_array[:, 0] == year_2020)]  # Filtering our data which their year are 2020
    total_graduate_2020 = graduate_2020[:, -1].sum()  # Calculating sum for last grade using numpy computation to get the graduation number
    print("Total Graduating Class of 2020:", total_graduate_2020)

    highest_enrollment = my_array[:, -3::].max()  # Calculating maximum enrollment using numpy computation in entire high school data (sub array)
    print("Highest Enrollment for a Single Grade:", highest_enrollment)

    lowest_enrollment = my_array[:, -3::].min()  # Calculating minimum enrollment using numpy computation in entire high school data (sub array)
    print("Lowest Enrollment for a Single Grade:", lowest_enrollment)


def main():
    # Print Stage 1 requirements here
    print("ENSF 592 School Enrollment Statistics")
    csv_file = r'School-data.csv'  # Address our data stored
    my_numpy_arr = read_csv_file(csv_file)  # Calling read_csv_file function to read our csv file
    stage_one(my_numpy_arr)  # Calling stage_one function and passing it our numpy array

    # Prompt for user input
    high_school_data = stage_two(my_numpy_arr)  # Prompting user to input data and keeping the selected high school data into a array
    # Print Stage 2 requirements here
    print("\n***Requested School Statistics***\n")
    school_stat(high_school_data)  # Printing required information

    # Print Stage 3 requirements here
    print("\n***General Statistics for All Schools***\n")
    stage_three(my_numpy_arr)  # Printing required information


if __name__ == '__main__':
    main()
