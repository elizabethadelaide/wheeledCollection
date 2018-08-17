# wheeledCollection
Data collection and analysis using wheeled devices to study mico-accessibility

# Concept

Use an android device attached to a wheelchair (or any wheeled device) to monitor surface conditions. Use accelerometers, computer vision and other sensors to detect poorly maintained sidewalks and curbcuts. Classify data and send with location data to database. Analyze data alongside GIS and other sources to study the impact of city planning and neighborhood demographics on small-scale accessibility.

# Current Progress

Laying out the skeleton of an android application, using Junit to create accelerometer analysis. Next is to classify events, such as sidewalk grade, wheelies (when a wheelchair user has to go over large bumps and lifts their casters up). I also want to find a way to attach a phone reliably to grade sidewalks using computer vision. Sidewalks might be able to be classified using edge detection or fourier analysis, into regular (planned issues) or irregular (broken, unmaintained) obstacles.

On the other end I will use Scala or perhaps R to analyze and combine datasets and present data.
