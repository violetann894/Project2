# The Smoother class is responsible for taking salted data and making it more
# understandable.
#
# Author: Rachel Hussmann
classdef Smoother

  # This section is like the body of a Java class.
  # This section is stating that the access to the method is public and the
  # class has one method.
  methods (Access = public)

    # The smoothData method accepst the salted y values and averages them with
    # a window of values around it to smooth the line and make the data more
    # understandable.
    #
    # Parameters: smooth - The Smoother object, yValues - The salted y values,
    # windowValue - The number of data points to be averaged to smooth the data,
    # runs - The number of times the smoothData method should be run
    #
    # Returns: smoothY - The smoothed y values
    function smoothY = smoothData(smooth, yValues, windowValue, runs)

      # Create the tempYValues list so it can hold all of the new averaged
      # values of y
      tempYValues = [];

      # Runs the program number of times the user wanted
      for c = 1 : runs

        # Iterate through the list
        for i = 1 : length(yValues)

          #Create the sum and averageCount variables to calculated the average
          # at the end
          totalSum = 0.0;
          averageCount = 0;

          # Iterate through the values to the left of the current index
          for j = 1 : windowValue

           # Check to see if the value would be out of bounds
           if i-j >= 1

              # If the value is not out of bounds, add the value to the sum and
              # add one to the average count
              totalSum += yValues(i-j);
              averageCount += 1;
            endif
          endfor

          # Add the current value to the sum and the increment the average count
          totalSum += yValues(i);
          averageCount += 1;

          # Iterate through the values to the right of the current index
          for j = 1 : windowValue

            # Check to see if the value would be out of bounds
            if i+j <= length(yValues)

              # If the value is not out of bounds, add the value to the sum and
              # add one to the average count
              totalSum += yValues(i+j);
              averageCount += 1;
            endif

          endfor

          # Add the average to the end of the list of tempYValues
          tempYValues(end+1) = totalSum/averageCount;

        endfor

        # Set yValues equal to tempYValues and empty tempYValues
        yValues = tempYValues;
        tempYValues = [];

      endfor

      # When the whole program is done, return the smoothed yValues
      smoothY = yValues;

    endfunction

  endmethods

endclassdef
