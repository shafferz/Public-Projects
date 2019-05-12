"""
Zachary Shaffer
Bioinformatics Lab #4
Professors J. Jumadinova and K. Webb
February 2016
This work is mine, unless otherwise cited.

This lab takes a file who's name is on the first line, and sequence
is on the following lines. The case of the sequences and names do not
matter, so long as the first line only contains the name of the
section of DNA being used, which is standard format.

Only works in Python 2.7, NOT Python 3+.
"""

my_file = open('sequence.fasta') # open file
count = 0 # a counter
name="" # the name of the sequence
sequence="" # default sequence dummy variable
ATG_count = 0 # counter for ATG codons
seqList = [] # a list of the individual bases
fileList = [] # a list of the lines of the code

#parse file
for line in my_file:
	if count == 0:
		name=line[1:-1] # remove the first and the last character
		print "\nName: ", name # print the name
	else:
		sequence=line.replace(" ","") # remove the spaces
		sequence=sequence.replace("\n","") # remove new lines
		sequence=sequence.upper() # convert the letters to upper case
		fileList.append(sequence) # append each line to a list of strings
	count+=1

for s in fileList: # This goes through every line of the file in this list, in strings
	for c in s: # This goes through every character of every line
		seqList.append(c) # This appends the characters to a long list

tempString = "" # dummy string
counter = 0 # a counter variable
my_list_triplets = [] # a list that will hold codons in strings of size 3

for letter in seqList: # goes through each letter of the sequence
	tempString += letter # adds each letter to the dummy string
	if counter < 2: # as long as we haven't added the third letter to the string
		counter += 1 # increment counter
	else: # otherwise
		my_list_triplets.append(tempString) # add the three-letter string (codon) to the list of codons
		counter = 0 # reset the counter
		tempString = "" # reset the tempString

my_boolean = False # boolean for whether or not the "first" ATG has been found

index = 0 # variable to track indices
first_index = -1 # some default value to indicate the first index location

for triplets in my_list_triplets: # for every codon in the list
	if triplets == "ATG" and not my_boolean: # if we found the ATG codon for the first time
		my_boolean = True # set the boolean to true, we found the first
		ATG_count += 1 # increment the ATG codon counter
		first_index = index # save the index of the first ATG codon
	elif triplets == "ATG" and my_boolean: # if we found any ATG codon after the first time
		ATG_count += 1 # increment the ATG counter
	else: # this codon is not ATG
		True	# does nothing
	index += 1 # increment the index after every codon

print "\nWe found %d ATG Codons in gene \"%s\".\nThe first was located at index %d in the list of codons."%(
	ATG_count,name,first_index) # final output
