#include <GL/glut.h> // (or others, depending on the system in use)
#include <stdio.h>

void init(void)
{
	glClearColor(1.0, 1.0, 1.0, 0.0); // Set display-window color to white.
	glMatrixMode(GL_PROJECTION); // SEt projection parameters.
	gluOrtho2D(0.0, 200.0, 0.0, 150.0);
}

void lineSegment(void)
{
	int x1, y1, x2, y2;

	printf("Please, enter two points (x1, y1) and (x2, y2).(only numbers)\n");
	scanf_s("%d %d %d %d", &x1, &y1, &x2, &y2);

	glClear(GL_COLOR_BUFFER_BIT); // Clear display window.
	glColor3f(0.0, 0.4, 0.2); // Set line segment color to green
	glBegin(GL_LINES);
	glVertex2i(x1, y1); // Specify line-segment geometry.
	glVertex2i(x2, y2);
	glEnd();
	glFlush(); // Process all OpenGL routines as quickly as possible.
}

void main(int argc, char** argv)
{
	glutInit(&argc, argv); // Initialize GLUT
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB); // Set display mode.
	glutInitWindowPosition(50, 100); // Set top-left display-window position
	glutInitWindowSize(400, 300); // Set display-window width and height
	glutCreateWindow("Assignment#2_1"); // Create display window
	init(); // Execute initialization procedure.
	glutDisplayFunc(lineSegment); // Send graphics to display window
	glutMainLoop(); // Display everything and wait.
}