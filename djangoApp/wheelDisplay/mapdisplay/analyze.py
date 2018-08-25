'''
Analyze data

Preprocessing -
a. Normalizes data
b. Converts data into x values?
c. Rotates 3D vectors
etc.

Processing
1. FFT
2. Peak Detection
3. Topography (Long slopes etc.)
4. Computer vision etc.
'''
import numpy as np #for signal Processing
import peakutils #for peak detection

import json

#get the 1D FFT of an Array of Data
def getFFT(buffer):
    length = len(buffer) #get buffer length
    #TODO: Make sure buffer as 2^n length
    mfft = np.fft.fft(buffer) #do fft
    return mfft

#Find peaks: https://blog.ytotech.com/2015/11/01/findpeaks-in-python/
def getPeaks(buffer, min_dist=100):
    threshold = 0.02 / max(buffer)
    indexes = peakutils.indexes(buffer, thres=threshold, min_dist=min_dist)
    return indexes

def get2DJSON(label, x, y):
    j = {}
    j.label = label
    j.x = x
    j.y = y
    return json.dumps(j, default=lambda o: o.__dict__)

#function reinterpolate data to distance speed instead of time
