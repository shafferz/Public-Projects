'''
Import statments and such.
'''
import nltk
import nltk.data
from nltk.sentiment.util import *
from nltk.sentiment.vader import SentimentIntensityAnalyzer

sid = SentimentIntensityAnalyzer()
sentences = open('ResponseData.txt')

'''
Declare lists to store data retreived from the sentiment intensity
The "compound" value indicates the intensity of the sentiment expressed, where
-1 < compound < 1, and the closer the number gets to -1 or 1, the more intense.
The positive value indicates, on a scale of 0 to 1, how positive the sentiment
is. Negative and neutral behave in the same way. The sum of the positive,
negative, and neutral values will be 1 for any given sentiment, as the values
are percentages of the whole sentiment. The compound value, however, is an
independent metric.
'''

compoundList = []
positiveList = []
neutralList = []
negativeList = []

'''
Get the sentiment of every review in the file.
'''

for sentence in sentences:
    ss = sid.polarity_scores(sentence)
    for k in sorted(ss):
        if (k == "compound"):
            compoundList.append(ss[k])
        elif (k == "neg"):
            negativeList.append(ss[k])
        elif (k == "neu"):
            neutralList.append(ss[k])
        elif (k == "pos"):
            positiveList.append(ss[k])
        else:
            print ("Everything went wrong")

'''
Calculate Averages for each of the categories for which I have data.
'''

compAverage = 0.0
posAverage = 0.0
neuAverage = 0.0
negAverage = 0.0

'''
Note: Since the compound value's intensity can either be strong positive or
strong negative, and I only am interested in the general intensity, I check to
see whether or not the intensity is positive or negative. If it's negative, I
make it positive for the purpose of calculating a comprehensive average
strength of intensity.
'''
for c in compoundList:
    if (c > 0):
        compAverage += c
    else:
        c *= -1
        compAverage += c
compAverage = compAverage/len(compoundList)

for p in positiveList:
    posAverage += p
posAverage = posAverage/len(positiveList)

for n in neutralList:
    neuAverage += n
neuAverage = neuAverage/len(neutralList)

for n in negativeList:
    negAverage += n
negAverage = negAverage/len(negativeList)

print("------------------------------------------")
print("Average compound value (intensity): %f" % (compAverage))
print("Average positive percent value: %f" % (posAverage))
print("Average neutral percent value: %f" % (neuAverage))
print("Average negative percent value: %f" % (negAverage))
print("------------------------------------------")
