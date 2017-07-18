# Monte Carlo Pi Simulator 

## This program simulates throwing darts on a board over and over again, with multiple trials. 
* Basically, the assumption is that a circle in a square will have an area of pi * r * r. We also make the assumption that 
the fraction of darts landing in the circle in relation to all darts that land, (circle / total) is proportional 
to the area of the circle divided by the area of the square. (a circle / a square)
* If we use a square with sides of one unit, the math becomes quite simple.
* The equation eventually works its way down to Pi = (n in circle / n attempts) * 4
* Solving this equation for Pi gives us mathematical proof for the number. 