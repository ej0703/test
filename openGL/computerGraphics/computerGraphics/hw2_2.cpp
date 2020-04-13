#include <GL/glut.h>

void display()
{
	glClear(GL_COLOR_BUFFER_BIT); // Clear display window.
	glutWireTeapot(.5); // (Relative size of the teapot(GLdouble))
	//glutSolidTeapot(.5); //draw a scene
	glFlush(); // Process all OpenGL routines as quickly as possible.
}

int main(int argc, char** argv)
{
	glutInit(&argc, argv); // Initialize GLUT
	glutInitWindowSize(500, 500); // the default window size is 300x300 (upper left corner)
	glutInitWindowPosition(0, 0);
	glutCreateWindow("Assignment#2_2");
	glutDisplayFunc(display);
	glutMainLoop(); // tell GLUT to wait for events.
}