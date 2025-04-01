# The Salter class is responsible for salting the y values from the function,
# with randomized integers between -bound and bound, which is a variable chosen
# by the user.
#
# Author: Rachel Hussmann
classdef Salter

  # This section is like the body of a Java class.
  # This section is stating that the access to the method is public and the
  # class has one method.
  methods (Access = public)

    # addSalt is the method that adds the random integer value to the y
    # values of a function.
    #
    # Parameters: salt - The Salter object, yValues - The y values from the
    # function that need to be salted, bound - The upper and lower bound of the
    # random number generator (-bound to bound)
    #
    # Returns: saltedValues - The salted y values of the function
    function saltedValues = addSalt(salt, yValues, bound)

      # Iterate through the elements in the yValues list
      for i = 1 : length(yValues)

          # Generate a new random integer between -bound and bound.
          # Add it to the current y in yValues
          yValues(i) = yValues(i) + randi([-bound, bound]);

      endfor

      #Return the newly salted values
      saltedValues = yValues;

    endfunction

  endmethods

endclassdef

