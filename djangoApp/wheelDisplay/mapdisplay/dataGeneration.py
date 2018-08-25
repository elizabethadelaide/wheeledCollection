
'''
Used to generate data when needed in place of real data
'''
import random
import numpy as np
import peakutils

#generate n points of noise data
def generateNoise(n, mu=0.0, sigma=0.5):
    out = []
    for x in range(0, n):
        out.append(random.gauss(mu, sigma))
    return np.array(out, dtype=float)
    
def generateSine(n, F=0.1, A=1.0):
    t = np.arange(n)
    return np.sin(t*F*2*3.141592654)*A

def someData():
    centers = (30.5, 72.3)
    x = np.linspace(0, 120, 121)
    y = (peakutils.gaussian(x, 5, centers[0], 3) +
        peakutils.gaussian(x, 7, centers[1], 10) +
        np.random.rand(x.size))
    return [x, y]
