import org.lwjgl.glfw.{GLFW, GLFWErrorCallback}
import org.lwjgl.system.MemoryUtil

/**
  * HelloScalaLWJGL
  *
  * Simple test class to open a window using LWJGL + Scala
  *
  * Author: Drew Malin (drew.malin@gmail.com)
  */
object HelloScalaLWJGL {

  object Defaults {
    val WINDOW_TITLE = "Hello Scala LWJGL!"
    val WINDOW_WIDTH = 1024
    val WINDOW_HEIGHT = 768
    val WINDOW_X = 100
    val WINDOW_Y = 100
  }

  private var window: Long = MemoryUtil.NULL
  private var running: Boolean = true


  def main(args: Array[String]): Unit = {
    init()
    while (isRunning()) {
      update()
      render()
      if (shouldStop()) {
        stop()
      }
    }
  }

  private def init(): Unit = {
    // Direct error messages to System.err
    GLFWErrorCallback.createPrint(System.err).set()

    // Abandon startup if GLFW initialization is not possible
    if (!GLFW.glfwInit()) {
      throw new IllegalStateException("Unable to initialize GLFW")
    }

    // Allow the window to be resizable
    GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE)

    // Create the window
    window = GLFW.glfwCreateWindow(Defaults.WINDOW_WIDTH, Defaults.WINDOW_HEIGHT, Defaults.WINDOW_TITLE, MemoryUtil.NULL, MemoryUtil.NULL)

    // Abandon startup if window creation fails
    if (window == MemoryUtil.NULL) {
      throw new IllegalStateException("Unable to create window")
    }

    GLFW.glfwSetWindowPos(window, Defaults.WINDOW_X, Defaults.WINDOW_Y)
    GLFW.glfwMakeContextCurrent(window)
    GLFW.glfwShowWindow(window)
  }

  private def isRunning(): Boolean = {
    running
  }

  private def update(): Unit = {
    // Poll for window events (close, resize, etc.)
    GLFW.glfwPollEvents()
  }

  private def render(): Unit = {
    GLFW.glfwSwapBuffers(window)
  }

  private def shouldStop(): Boolean = {
    GLFW.glfwWindowShouldClose(window)
  }

  private def stop(): Unit = {
    running = false
  }
}
