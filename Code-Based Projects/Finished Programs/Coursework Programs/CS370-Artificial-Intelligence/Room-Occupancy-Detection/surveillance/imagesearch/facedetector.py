# import the necessary packages
import cv2

''' use the built-in Haar cascade classifiers in OpenCV. Luckily for us, these classifiers have already been pre-trained to recognize faces!

If we wanted to build our own classifier, we would need a lot of positive and negative images. Positive images would contain images with faces, whereas negative images would contain images without faces. Based on this dataset, we could then extract features to characterize the face (or lack of face) in an image and build our own classifier.

These classifiers work by scanning an image from left to right, and top to bottom, at varying scale sizes. Scanning an image from left to right and top to bottom is called the sliding window approach.
As the window moves from left to right and top to bottom, one pixel at a time, the classifier is asked whether or not it thinks there is a face in the current window, based on the parameters that are supplied to the classifier.'''


# define the FaceDetector class, which will encapsulate all the necessary logic to perform face detection

class FaceDetector:
	''' Define the constructor, which takes a single parameter - the path to where his cascade classifier lives. This classifier is serialized as an XML file. Making a call to cv2.CascadeClassifier will deserialize the classifier, load it into memory, and allow us to detect faces in images.'''
	def __init__(self, faceCascadePath):
		# load the face detector
		self.faceCascade = cv2.CascadeClassifier(faceCascadePath)
	
	# define the detect method to actually find the faces in an image
	''' This function takes one required parameter, the image that he wants to find the faces in, followed by three optional arguments.'''
	def detect(self, image, scaleFactor = 1.1, minNeighbors = 5, minSize = (30, 30)):
		# detect the actual faces in the image
		'''The detectMultiScale method then returns rects, a list of tuples containing the bounding boxes of the faces in the image. These bounding boxes are simply the (x, y) location of the face, along with the width and height of the box.'''
		rects = self.faceCascade.detectMultiScale(image,
			scaleFactor = scaleFactor, minNeighbors = minNeighbors,
			minSize = minSize, flags = cv2.CASCADE_SCALE_IMAGE)

		# return the rectangles representing bounding
		# boxes around the faces
		return rects
