.data
	str:	.asciiz		"MIPS is awesome!"
	str2:	.asciiz		"The length of the string is: "
	length:	.word 		0

.text

	la $t0, str			# $t0 holds the string address
	li $t1, 0			# $t1 holds the character count
	la $t4, str2
	
	li $v0, 4
   	move $a0, $t4
   	syscall
	
   loopTop:				# top of our loop
   	lb $t2, 0($t0)			# load the character at address $t0
   	
   	bne $t2, $zero, notEqual	# jump to notEqual if things aren't equal
   	
   	# found our end of string
   	li $v0, 1			# setting syscall 1
   	move $a0, $t1			# copying the string length
   	syscall				# issuing the system call
   	
   	sw $t1, length
   	
   	li $v0, 10			# setting syscall 10
   	syscall				# issuing the system call
   	
   	
  notEqual:
  	addi $t1, $t1, 1		# increment $t1
  	addi $t0, $t0, 1		# move to the next char
  	j loopTop			# jump to the top of the loop
