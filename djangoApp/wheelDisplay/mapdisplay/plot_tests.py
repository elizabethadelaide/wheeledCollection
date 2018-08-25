

import matplotlib.pyplot as plt
import numpy as np

import dataGeneration as generate
import analyze

'''
Do Plotting tests on analysis
TODO: Analytical tests
'''

#helper function for plotting FFT
def plotFFT(t, sp):
    freq = np.fft.fftfreq(t.size, d=1)
    plt.plot(freq, sp.real, freq, sp.imag)
    plt.show()

def plotIndexes(x, y, i):
    plt.plot(x, y)
    for k in range(0, len(i)):
        plt.scatter(i[k], y[i[k]], c=y[i[k]]*255, marker='x')
    plt.show()

#A. Basic fft test
whiteNoise = generate.generateNoise(2048) #2048 samples of noise
whiteSpectrum = analyze.getFFT(whiteNoise)
plotFFT(whiteNoise, whiteSpectrum)

sinWave = generate.generateSine(2048, F=0.001)
sinSpectrum = analyze.getFFT(sinWave)
plotFFT(sinWave, sinSpectrum)

indexes = analyze.getPeaks(sinWave)
plotIndexes(np.arange(2048), sinWave, indexes)

x, y = generate.someData()
spectrum = analyze.getFFT(y)
plotFFT(y, spectrum)
plotIndexes(x, y, analyze.getPeaks(y))
