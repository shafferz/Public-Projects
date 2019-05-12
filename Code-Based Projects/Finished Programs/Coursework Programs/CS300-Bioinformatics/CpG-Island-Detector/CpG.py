"""
Logan Billet and Zachary Shaffer
Lab 12 - CpG Prediction Algorithm
April 08, 2016
"""

from __future__ import division

my_file = open('1q25.txt')
count = 0
name = ""
sequenceLine = ""
seq = ""

# parse through the whole file and save all seq in a list
for line in my_file:
	if count==0:
		name=line[1:len(line)]
		print "Name: ", name
	else:
		sequenceLine = line.upper()
		seq = seq + sequenceLine
	count+=1

my_file.close()

window = input("Enter the CpG Scanning Window: ")

lenSeq = len(seq)
ratios=[None]*((lenSeq-window)+1)

for i in range (0, (lenSeq-window)+1):
	cCtr = gCtr = cgCtr = 0

	for j in range (0, window-1):
		if (seq[j+i] == 'C'):
			cCtr = cCtr + 1
			if (seq[j+i+1] == 'G'):
				cgCtr = cgCtr + 1
		elif (seq[j+i] == 'G'):
			gCtr = gCtr + 1
	if ((cCtr*gCtr)>0):
		denom = (cCtr*gCtr)/window
		ratios[i] = cgCtr/denom
	else:
		ratios[i] = 0

for I in range (0, len(ratios)):
	if (ratios[I] > 1.5):
		print (I+1, ratios[I], "***")
	elif (ratios[I] > 0.0):
		print (I+1, ratios[I])
