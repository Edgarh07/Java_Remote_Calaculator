# Java_Remote_Calaculator
Here are 2 Java projects I worked on for my undergraduate Adavance Operating system class at California State University, San Bernardino.

Part A is a remote calculator that prints out the result of the arithmetic equation that was entered into the Android application to a terminal that is connected remotely to a server.
Created a graphical interface of a simple calculator that can handle integer arithmetic, including addition, subtraction, multiplication and division. Then made the Android calculator a client; a user clicks on the UI to input two integers and an operation (+, -, *, / ). It sends the two integers and the operator to a remote java server program through RMI or other means. The remote server program sends the result back to the Android client, which displays the result on the UI.

<img width="904" alt="Screen Shot 2021-08-06 at 4 44 14 PM" src="https://user-images.githubusercontent.com/55567320/128580484-b2744888-894c-472c-9249-5160c564e281.png">


Part B, the Android device presents a UI to let a user enter the number of random numbers the user wants, the lower bound, and upper bound of the numbers. The device sends the parameters to a remote server, which returns the random numbers to be displayed by the Android device.

<img width="987" alt="Screen Shot 2021-08-06 at 4 44 26 PM" src="https://user-images.githubusercontent.com/55567320/128580490-2b1f2bbb-fcb8-4b79-9798-7a4d5f8778f4.png">
