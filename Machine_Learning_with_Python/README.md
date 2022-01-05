# AI
### Project 1: CNN Classification for Face Recognition 
* Dogs Vs Cats face recognition using convolutional neural network with 99% test accuracy.
##
### Project 2: The goal of this project is to become familiar with the scikit-learn library.
* We practice loading example datasets, perform classification and regression with multiple scikit-learn models, and compare results between using all features and two principal components as features.
* We answer to four key questions based on the result we get from this project.

Questions:
1. For each task (classification and regression), which model performs best on the validation data using all features?
2. For each task (classification and regression), which model performs best on the validation data using two principal components?
3. In each task (classification and regression), for each model, how do full feature and two principal component model scores compare on the validation data?
4. Do any of the models underfit or overfit? 

Answers:
* All the answers and necessary information is provided in the related notebook.
##
### Project3: Concrete Compressive Strength Regression
* The goal of this lab is to become familiar a regression workflow by training models to predict concrete strength \[MPa\] based on concrete mixture information using the yellowbrick concrete dataset.

We will try and compare your results to priviously reported models:
- Polynomial regression: training RMS=3.96 MPa 􏰀(R2 = 0.890); testing RMS=8.82 MPa (􏰀R2 = 0.791)􏰁 
- Neural network: training RMS=3.01 MPa (􏰀R2 = 0.940);􏰁 testing RMS=4.32 MPa 􏰀(R2 = 0.929)

**Assumption:** We are assuming that the yellowbrick dataset was used in the reference article and that 20% of the data served as the test set.

Models will be trained to minimize root-mean squared error (RMS), as in the reference article. Note that sklearn works with *maximization* and it is custom to *maximize* the *negative* RMS.

Background: The yellowbrick concrete dataset originates from UCI and was referenced to the following publication:
>Yeh, I-Cheng. 2006. “Analysis of Strength of Concrete Using Design of Experiments and Neural Networks.” Journal of Materials in Civil Engineering 18 (4): 597–604. https://doi.org/10.1061/(ASCE)0899-1561(2006)18:4(597).

We are going to apply our skills and compare our results to the polynomial regression model and neural network.
##
