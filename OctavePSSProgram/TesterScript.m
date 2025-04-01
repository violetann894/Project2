# Create the natural log data points
ln = LogFunction(1, 100);

# Get the x and y values of the natural log
x = ln.get_x();
y = ln.get_y();

# Plot the natural log function
plot(x,y);
title("Plot of Natural Log Function");

# Create a new Salter object to salt the data
salt = Salter();

# Salt the y values
m = salt.addSalt(y, 100);

# Create a new graph and plot the salted natural log function
figure;
plot(x,m);
title("Plot of salted Natural Log Function");

# Add the salted values to a matrix to write it to a .csv file
saltedValues = [x;m];

# Octave has a built in method to put values into .csv files, so I am using it
# to mimic my code from my Java PSS project, as well as to practice using the
# language.
csvwrite("C:/Users/Rache/OctaveFiles/Project2/saltedValues.csv", saltedValues);

# Read the csv values and place them into a matrix
saltedValueMatrix = csvread("C:/Users/Rache/OctaveFiles/Project2/saltedValues.csv");

# Get each row of the matrix and set them to their respective vectors
# Using the colon in the index allows the program to take the column values of
# the row, eventually adding up to a row vector of values.
saltedXValues = saltedValueMatrix(1, :);
saltedYValues = saltedValueMatrix(2, :);

# Create a new Smoother object and smooth the y values
smooth = Smoother();
smoothedYValues = smooth.smoothData(saltedYValues, 5, 4);

# Create a new graph and plot the smoothed natural log function
figure;
plot(saltedXValues, smoothedYValues);
title("Smoothed plot of Natural Log Function");

# Add the smoothed values to a matrix to write it to a .csv file
smoothedValues = [saltedXValues; smoothedYValues];

# Write the smoothed values to a .csv file
csvwrite("C:/Users/Rache/OctaveFiles/Project2/smoothedValues.csv", smoothedValues);
