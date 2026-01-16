# Intro to OpenGL
## some words to know
| words | meanings |
|-------|----------|
| lavish     | 大量的     |
| idle    | 闲置的     |
| <++>  | <++>     |
| <++>  | <++>     |


## some concepts
- `rendering` converting 3D world to a 2D image
-  `rasterization` process involved in rendering
- `openGL` serve as API 
    - how to create objects in openGl

    Using function `glGen*` where `star` is the name of the object.
    The function takes two parametr, first parameter is the num of
    object, second parameter is `Gluint*` array

- what is double buffer means
   The buffer being shownn is the front buffer, and drawing process taken
   part in second buffer, That is you display data from first buffer, 
   and change data in second buffer.

## FreeGLUT

The framework file expects 5 functions to be defined: 
1. defaults 
2. init
3. display The most important
4. reshape
5. keyboard.

### display function
```cpp
glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // sets the color when we do color clearing
glClear(GL_COLOR_BUFFER_BIT);// this function clean the screen with the set color

glUseProgram(theProgram);

glBindBuffer(GL_ARRAY_BUFFER, positionBufferObject);
glEnableVertexAttribArray(0);
glVertexAttribPointer(0, 4, GL_FLOAT, GL_FALSE, 0, 0);

glDrawArrays(GL_TRIANGLES, 0, 3);

glDisableVertexAttribArray(0);
glUseProgram(0);

glutSwapBuffers();
```

