"""
Zachary Shaffer
Professors J. Jumadinova and K. Webb
CompSci 300 - BioInformatics
February 26, 2016

Requires Python 2.7. Require biopython module.
To install biopython, run the following command (linux):

[sudo] pip install biopython

This program is designed to take two fasta files as input, translate them, and detect mutations in the protein sequences they create.
This work is mine unless otherwise cited.
"""

from Bio.Seq import Seq
from Bio.Alphabet import IUPAC

codes = dict(GCA='A', GCC='A', GCG='A',GCU='A',
             AGA='R', AGG='R', CGA='R', CGC='R', CGG='R', CGU='R',
             AAU='N', AAC='N',
             GAC='D', GAU='D',
             UGC='C', UGU='C',
             GAA='E', GAG='E',
             CAA='Q', CAG='Q',
             GGA='G', GGC='G', GGG='G', GGU='G',
             CAC='H', CAU='H',
             AUA='I', AUC='I', AUU='I',
             CUA='L', CUC='L', CUG='L', CUU= 'L', UUA='L', UUG='L',
             AAA='K', AAG='K', AUG='M',
             UUC='F', UUU='F',
             CCA='P', CCC='P', CCG='P', CCU='P',
             AGC='S', AGU='S', UCA='S', UCC='S', UCG= 'S', UCU='S',
             ACA='T', ACC='T', ACG='T', ACU='T',
             UGG='M',
             UAC='Y', UAU='Y', GUA='V', GUC='V', GUG='V', GUU='V',
             UAA='-', UAG='-', UGA='-')

my_alpha = IUPAC.unambiguous_dna

infile1 = open('MutantAWildType.fasta', 'r')

seq1 = ""

infile1.readline()  # bypass > header line
for line in infile1:
    line = line.replace('\n', '')
    seq1 = seq1 + line

# convert to all capital letters
seq1 = seq1.upper()
print seq1
infile1.close()

infile2 = open('MutantB.fasta', 'r')

seq2 = ""

infile2.readline()  # bypass > header line
for line in infile2:
    line = line.replace('\n', '')
    seq2 = seq2 + line

# convert to all capital letters
seq2 = seq2.upper()
print seq2
infile2.close()

# Convert seq1 and seq2 string into a a Sequence object, so we can use Seq functions
dna_seq1 = Seq(seq1, my_alpha)
dna_seq2 = Seq(seq2, my_alpha)

# input
temp1 = raw_input('Is the first sequence template or nontemplate? ')
orient1 = raw_input ('Enter the orientation 5-3 or 3-5: ')
output1 = ""

if temp1=='template':
	if orient1=='3-5':
		output1 = dna_seq1.complement()
	elif orient1=='5-3':
		output1 = dna_seq1.reverse_complement()
elif temp1=='nontemplate':
	if orient1=='3-5':
		output1 = Seq(seq1[::-1]) # reverse string
	elif orient1=='5-3':
		output1 = dna_seq1

temp2 = raw_input('Is the second sequence template or nontemplate? ')
orient2 = raw_input ('Enter the orientation 5-3 or 3-5: ')
output2 = ""

if temp2=='template':
	if orient2=='3-5':
		output2 = dna_seq2.complement()
	elif orient2=='5-3':
		output2 = dna_seq2.reverse_complement()
elif temp2=='nontemplate':
	if orient2=='3-5':
		output2 = Seq(seq2[::-1]) # reverse string
	elif orient2=='5-3':
		output2 = dna_seq2

rna_seq1 = (output1.transcribe()).rstrip() # transcribe the DNA of the first sequence into RNA
rna_seq2 = (output2.transcribe()).rstrip() # transcribe the DNA of the second

"""
This is a fix I implemented to fix what BioPython does with it's Seq object, where it
leaves a "\r" in the seq at the beginning, and therefore will not translate with the
translate() method. Instead, I convert it to a string, remove the floating "\r" at the
beginning of the lines, and use the old fashioned way of making amino acid strings.
"""
rna1 = str(rna_seq1).replace('\r', '')
rna2 = str(rna_seq2).replace('\r', '')

# had to use the old fashioned way of getting the amino acids because translate wouldn't work.

amino_seq1 = ""

for i in range(0, len(rna1), 3):
	amino_seq1 += codes[rna1[i:i+3]]
	# use the codes dictionary to produce the amino acids

amino_seq2 = ""

for i in range(0, len(rna2), 3):
	amino_seq2 += codes[rna2[i:i+3]]
	# use the codes dictionary to produce the amino acids

fileOutput = open('results.txt', 'w')
count = 0

for c in range(0, len(amino_seq1)):
	if amino_seq1[c] != amino_seq2[c]:
		print amino_seq1[c] + " instead of " + amino_seq2[c] + " at " + str(c)
		fileOutput.write(amino_seq1[c] + ", " + amino_seq2[c] + ", " + str(c)+"\n")
		count += 1

if count == 0:
	print "No mismatches found in the amino acid sequences!"
	fileOutput.write("No mismatches found in the amino acid sequences!")

fileOutput.close()
