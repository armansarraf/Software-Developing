# calculator.py
# Arman Sarraf

# A terminal-based calculator application for determining the result of a mathematical expression containing three
# values and two operators.

# Function_1: Gets two input value and an operator, calculate and returns the result.
def operation(first_value, second_value, operator):
    # operators = ('+', '-', '*', '/')
    if operator == '+':  # if condition to evaluate which calculation should be done.
        result = first_value + second_value
    elif operator == '-':
        result = first_value - second_value
    elif operator == '*':
        result = first_value * second_value
    elif operator == '/':
        result = first_value / second_value
    else:
        print("The input has not been recognized")
    return result


# Function_2: Asks from the user to type the desired input, and returns the values.
def get_input_values():
    operator_list = ["+", "-", "*", "/"]  # Compound data type.
    first_input_number = int(input("Please enter your first number : "))  # Gets the first integer from user.
    flag = True
    while flag:  # While loop is used to see if the operator typed by user is valid.
        first_operator = input("Please enter the first operator (+, -, *, /) : ")  # Gets the first operator.
        if first_operator in operator_list:  # If input operator is valid then, next codes will be executed.
            flag = False  # Flag is used to stop while loop.
        else:
            print(
                "The input value is not valid as an operator")  # If th operator is not valid, this message will be shown to user.

    second_input_number = int(input("Please enter your second number : "))  # Gets the second integer from user.
    flag = True
    while flag:  # While loop is used to see if the operator typed by user is valid.
        second_operator = input("Please enter the second operator (+, -, *, /) : ")  # Gets the second operator.
        if second_operator in operator_list:  # If input operator is valid then, next codes will be executed.
            flag = False  # Flag is used to stop while loop.
        else:
            print(
                "The input value is not valid as an operator")  # If th operator is not valid, this message will be shown to user.

    third_input_number = int(input("Please enter your third number : "))  # Gets the third integer from user.
    return first_input_number, first_operator, second_input_number, second_operator, third_input_number  # Returning input values.


# Function_3: This function specifies which operator has priority. Takes values from get_input_values, calls operation and pass values then, prints the result
def calculation(first_input_number, first_operator, second_input_number, second_operator, third_input_number):
    print_output = print_input_values(first_input_number, first_operator, second_input_number, second_operator,
                                      third_input_number)

    if (first_operator == '/' and second_input_number == 0) or (
            second_operator == '/' and third_input_number == 0):  # If condition checks for division by 0

        print("The calculation is impossible! Because numbers can not be divided by zero")

    elif (second_operator == '*' or second_operator == '/') and (
            first_operator == '+' or first_operator == '-'):  # Checks if operation_2 should be done before operation_1 (order of operations)

        result = operation(int(second_input_number), int(third_input_number),
                           second_operator)  # Calls the 'operation' function, recives the result of operator_2

        print(print_output, operation(int(first_input_number), int(result),
                                      first_operator))  # Calls the 'operation' function, assigns the result of operation_2 as second_value, receives and prints the result of operation_1

    else:  # Operation_1 is done before operation_2 (order of operations)

        result = operation(int(first_input_number), int(second_input_number),
                           first_operator)  # Calls the 'operation' function, receives the result of operation_1

        print(print_output, operation(int(result), int(third_input_number),
                                      second_operator))  # Calls the 'calculating' function, assigns the total of act1 as num1, recives and prints the total of act2


# Function_4: prints the values typed by user before showing the results and return the desired string.
def print_input_values(first_input_number, first_operator, second_input_number, second_operator, third_input_number):
    output_string = "The result after calculation {} {} {} {} {}: is = ".format(first_input_number,
                                                                                first_operator, second_input_number,
                                                                                second_operator, third_input_number)
    return output_string


# Function_5: main function execute the program.
def main():
    number_1, op_1, number_2, op_2, number_3 = get_input_values()

    calculation(number_1, op_1, number_2, op_2, number_3)


if __name__ == '__main__':
    main()
