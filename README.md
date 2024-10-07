# Matrix Manager CLI

Matrix Manager CLI is a command-line application for managing and performing operations on matrices. This tool allows you to create, manipulate, and display matrices with ease. It supports various matrix operations including addition, subtraction, scalar multiplication, and matrix multiplication.

## Features

- **Create Matrices**: Easily create matrices of any size with the option to auto-populate or manually populate the elements.
- **List Matrices**: View all matrices stored in the application.
- **Matrix Operations**: Perform operations such as addition, subtraction, scalar multiplication, and matrix multiplication.
- **Interactive Menu**: User-friendly menu-driven interface for managing matrices and performing operations.

## Installation

1. **Clone the repository:**
  ```bash
  git clone https://github.com/erisdll/matrices-cli.git
  cd matrices-cli
  ```

2. **Compile the Java files:**
  ```bash
  javac src/*.java
  ```

3. **Run the application:**
```bash
  java -cp src Main
  ```

## Usage
Upon running the application, you'll be greeted with a main menu. The available options are:

1. **Create a new matrix**: 
    - Select the option to create a new matrix.
    - Specify the number of rows and columns.
    - Choose whether to auto-populate or manually populate the matrix.

2. **List existing matrices**: 
    - View all matrices currently stored. Each matrix will be displayed with its index number.

3. **Select a matrix for further operations**: 
    - Choose a matrix from the list by its index number to perform further operations:
        - Repopulate Matrix: Change the values of the matrix elements.
        - Change an Element's Value: Update a specific element in the matrix.
        - Add Another Matrix: Add two matrices together.
        - Subtract Another Matrix: Subtract one matrix from another.
        - Multiply by Scalar: Multiply the matrix by a scalar value.
        - Multiply by Another Matrix: Perform matrix multiplication.
        - Delete Matrix: Remove a matrix from the list.
        - Select Another Matrix: Switch to another matrix.

#### **Creating a Matrix Example**
  ```bash
  Main Menu > 1
  Insert number of rows: integer
  Insert number of columns: integer
  Type 1 to auto populate the matrix.
  Type 2 to manually populate the matrix.
```
#### **Selecting a Matrix Example**

```bash
  Main Menu > 3
  List of matrices:

  Matrix n.1:
  1.0 2.0
  3.0 4.0

  Matrix n.2:
  5.0 6.0 
  7.0 8.0

  Enter the number of the matrix you want to select: > 1

  Selected Matrix:
  1.0 2.0
  3.0 4.0
```

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries, please contact me directly.
