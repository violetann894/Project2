# The LogFunction class is responsible for calculating the x and y values of a
# natural logarithmetic function, to then be used as data points for the Salter
# and Smoother classes.
#
# Author: Rachel Hussmann
classdef LogFunction

  # This section is like Java's instance variables section
  # This section is stating that the access to the variables is private and
  # the class only has two variables, the x values and the y values.
  properties(Access = private)
    x = 0;
    y = 0;
  endproperties

  # This section is like the body of a Java class.
  # This section is stating that the access to the methods is public and the
  # class has three methods.
  methods (Access = public)

    # LogFunction is the constructor for the LogFunction class
    #
    # Parameters: startingValue - The starting x value (inclusive),
    # finishingValue - The final x value (inclusive)
    #
    # Returns: ln - The newly created LogFunction object
    function ln = LogFunction(startingValue, finishingValue)

      # Set the vector that will hold the evenly spaced values between
      # startingValue and finishingValue
      ln.x = linspace(startingValue, finishingValue);

      # Set the vector that will hold the y values to the natural log
      # calculations
      ln.y = log(ln.x);
    endfunction

    # Getter for the variable x, which holds the x values of the function.
    #
    # Parameters: ln - The LogFunction object (Octave handles parameters much
    # like Python does, the first parameter for any function must be the object)
    #
    # Returns: x - The x values associated with the function
    function x = get_x(ln)
      x = ln.x;
    endfunction

    # Getter for the variable y, which holds the y values of the function.
    #
    # Parameters: ln - The LogFunction object (Octave handles parameters much
    # like Python does, the first parameter for any function must be the object)
    #
    # Returns: y - The y values associated with the function
    function y = get_y(ln)
      y = ln.y;
    endfunction

  endmethods
endclassdef
