# encryption.py
# Arman Sarraf
# A terminal-based encryption application capable of both encoding and decoding text when given a specific cipher.
# Test >>>
# Text: "This is an example sentence with 098273409870 and @#($*&@)#(*$)&."
# Cipher: 1234qwertyu6789asdfghjzxcv
# pyResult: grtftf18qx17a6qfq8gq83qztgr184
import re


class GetInput:
    """
    GetInput class is used to give the clear instructions to the user for getting the information from them, and changing the input to the be passed
    to other classes.
    Takes no argument.
    :returns  option (1 or 2), plain text or encoded text, cipher text
    """

    def __init__(self):
        self.option = ''
        self.convert_text = re.compile(
            '[a-z]')  # Defining a regular expression to separate just lowercase a-z from a string (input text)
        self.convert_text_cipher = re.compile(
            '[a-z0-9]')  # Defining a regular expression to separate just lowercase a-z and numbers 0-9 (input cipher)

    def choose_option(self):
        """
        choose_option gives the user the option to choose just 1 for encode or just 2 for decode. If user types any other number of letter, they will be
        noticed that the input is not correct. After typing the right value, it checks the input to see if it is 1 or 2
        Take no argument.
        :return: option
        :rtype: integer
        """

        while True:

            self.option = input('Choose 1 for encoding or, 2 for decoding your text:')

            if self.option in '1 2'.split():  # Checking if the user input is '1' or '2'

                return int(self.option)

            else:
                print('The input is invalid! You should enter 1 or 2.')

    def get_plain_message(self):
        """
        This function is used when option 1 (encoding) is chosen. It gets the plain text in any format from user, changes it to
        lowercase letters, removes any number or special characters, and then converts it to a list of chars in order to be passed through encoding class.
        Take no argument.
        :return: a list of characters to be encoded, original input to be shown to the user, helper.join which is converted string to be shown to the user.
        :rtype: list (iterable object), string, string
        """
        input_text = input('Please Enter Your text :')
        input_text_lower = input_text.lower()  # Change the user input text to lower case letters
        final_text = self.convert_text.findall(
            input_text_lower)  # Keeping just a list of lowercase characters using regular expression (regarding condition in Specification)
        helper = ""  # Using a variable to print the string which is being encoded. (Using .join method to build a string from characters)
        return final_text, input_text, helper.join(final_text)

    def get_encoded_message(self):
        """
        This function is used when option 2 (decoding) is chosen. Regarding specification and instruction, we should NOT check the encoded input value.
        Take no argument.
        :return: a list of characters which are encoded text input, original encoded input text
        :rtype: list (iterable object), string
        """
        input_text = input('Please Enter Your encoded text :')
        final_text = []
        final_text[:] = input_text  # Putting user input into a list in order to be passed through decoding class.
        return final_text, input_text

    def get_cipher(self):
        """
        This function gets the cipher text from user, checks if the input includes just 26 elements lowercase letters or numbers.
        If not, it raises a ValueError and notice the user that input is not valid and they should type a valid cipher again. After receiving the correct
        cipher, it puts all the characters into a list to be passed to other classes.
        Take no argument.
        :return: a list of characters from cipher, a string to show the cipher to the user.
        :rtype: list (iterable object), string
        """
        flag = True
        while flag:
            try:
                input_cipher = input('Please enter the cipher text:')
                result = bool(re.match('^[a-z0-9]*$', input_cipher))  # Check ciphertext using a regular expression (regarding condition in Specification)
                if len(input_cipher) == 26 and result:
                    flag = False
                    final_cipher = self.convert_text_cipher.findall(input_cipher)
                    helper = ''  # Using a variable to print the string which is being encoded. (Using .join method to build a string from characters)
                    return final_cipher, helper.join(final_cipher)
                else:
                    raise ValueError  # using a ValueError to tell the user that entered cipher is not correct
            except ValueError:
                print('The cipher text must be 26 elements of a-z or 0-9!')


class Encoding:
    """
    Encoding class is defined to encode a text with the entered cipher text. It gets plain_text and cipher_text as input and returns the encoded text
    Takes plain_text, cipher_text as arguments.
    :returns encoded text
    """

    def __init__(self, plain_text, cipher_text):
        self.plain_text = plain_text
        self.cipher_text = cipher_text
        self.alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                         's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

    def encode_message(self):
        """
        This function checks every single character in the plain text and compares them with alphabet to get the index. Then from the number of index,
        it iterates the ciphertext to see in that index, what character exist. Then adds that char to the final encoded string.
        Take no argument.
        :return: encoded text
        :rtype: string
        """
        encoded_text = ""
        for letter in self.plain_text:  # for every letter in input text finds the index of that letter in the alphabet.
            letter_index = self.alphabet.index(letter)
            encoded_text += self.cipher_text[letter_index]  # compare letter index with cipher index to see what letter of cipher exist in that index.

        return encoded_text


class Decoding:
    """
    Decoding class is defined to decode the encoded text with the entered cipher. So it gets the encoded text and the cipher, then decode the text and
    after that returns the decoded string
    Takes encoded_input_text, cipher_text as arguments.
    :returns decoded string
    """
    def __init__(self, encoded_input_text, cipher_text):
        self.encoded_input_text = encoded_input_text
        self.cipher_text = cipher_text
        self.alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                         's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

    def decode_message(self):
        """
        This function checks every single character in the encoded text and compares them with ciphertext to get their index. Then from the number of index,
        it iterate the alphabet to see in that index, what character exist. Then adds that char to the final decoded string.
        Take no argument.
        :return: decoded text
        :rtype: string
        """
        decoded_text = ""
        for letter in self.encoded_input_text:  # for every letter in encoded input text finds the index of that letter in the cipher text.
            letter_index = self.cipher_text.index(letter)
            decoded_text += self.alphabet[letter_index]  # compare letter index with alphabet index to see what letter of alphabet exist in that index.

        return decoded_text


def main():
    print("ENSF 592 Encryption Program")
    my_get_input = GetInput()  # Building an object from GetInput class
    option = my_get_input.choose_option()  # Using choose_option method in GetInput class
    if option == 1:  # The condition to see if the user wants to encode or decode a text
        text, original_text, to_be_processed = my_get_input.get_plain_message()  # Getting text from user
        cipher, original_cipher = my_get_input.get_cipher()  # Getting cipher text from user
        my_encode = Encoding(text, cipher)  # Building an object from Encoding class
        encoded_result = my_encode.encode_message()  # Using encode_message function
        print("***************************************************")
        print("Original text: ", original_text)
        print("Processed string to be encoded: ", to_be_processed)
        print("Cipher text is: ", original_cipher)
        print("Encoded text: ", encoded_result)
        print("***************************************************")
    else:  # The condition to see if the user wants to encode or decode a text.
        text, original_text = my_get_input.get_encoded_message()  # Getting text from user
        cipher, original_cipher = my_get_input.get_cipher()  # Getting cipher text from user
        my_decode = Decoding(text, cipher)  # Building an object from Decoding class
        decoded_result = my_decode.decode_message()  # Using decode_message function
        print("***************************************************")
        print("Text to be decoded: ", original_text)
        print("Cipher text is: ", original_cipher)
        print("Decoded text: ", decoded_result)
        print("***************************************************")


if __name__ == '__main__':
    main()
