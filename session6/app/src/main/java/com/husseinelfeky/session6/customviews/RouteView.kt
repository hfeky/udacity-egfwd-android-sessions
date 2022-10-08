package com.husseinelfeky.session6.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.husseinelfeky.session6.R
import com.husseinelfeky.session6.utils.dp

class RouteView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()

    var routeColor = Color.BLACK
        private set

    var routeOrientation = RouteOrientation.VERTICAL
        set(value) {
            field = value
            updateLayoutDirection()
        }

    var routeShape = RouteShape.SINGLE
        set(value) {
            field = value
            updateLayoutDirection()
        }

    private var drawingRouteShape = routeShape

    enum class RouteOrientation {
        VERTICAL, HORIZONTAL
    }

    enum class RouteShape {
        SINGLE, MIDDLE, LEFT, RIGHT, START, END
    }

    init {
        context.withStyledAttributes(
            attrs,
            R.styleable.RouteView,
            defStyleAttr,
            0
        ) {
            routeColor = getColor(R.styleable.RouteView_routeColor, routeColor)

            routeOrientation = RouteOrientation.values()[
                    getInt(
                        R.styleable.RouteView_orientation,
                        0
                    )
            ]

            routeShape = RouteShape.values()[getInt(R.styleable.RouteView_shape, 0)]
        }

        paint.isAntiAlias = true
        paint.color = routeColor
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = 60.dp.toInt()
        val desiredHeight = 60.dp.toInt()

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        // Measure width.
        val width = when (widthMode) {
            MeasureSpec.EXACTLY -> {
                // Must be this size
                widthSize
            }
            MeasureSpec.AT_MOST -> {
                // Can't be bigger than min(desiredWidth, widthSize)
                desiredWidth.coerceAtMost(widthSize)
            }
            else -> {
                desiredWidth
            }
        }

        // Measure height.
        val height = when (heightMode) {
            MeasureSpec.EXACTLY -> {
                // Must be this size
                heightSize
            }
            MeasureSpec.AT_MOST -> {
                // Can't be bigger than min(desiredHeight, heightSize)
                desiredHeight.coerceAtMost(heightSize)
            }
            else -> {
                desiredHeight
            }
        }

        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(width / 2.0f, height / 2.0f, FOUR_DP, paint)

        paint.strokeWidth = THREE_DP

        if (routeOrientation == RouteOrientation.VERTICAL) {
            when (drawingRouteShape) {
                RouteShape.LEFT -> canvas.drawLine(
                    width / 2.0f,
                    height / 2.0f,
                    width / 2.0f,
                    height.toFloat(),
                    paint
                )
                RouteShape.MIDDLE -> canvas.drawLine(
                    width / 2.0f,
                    0f,
                    width / 2.0f,
                    height.toFloat(),
                    paint
                )
                RouteShape.RIGHT -> canvas.drawLine(
                    width / 2.0f,
                    0f,
                    width / 2.0f,
                    height / 2.0f,
                    paint
                )
                else -> return
            }
        } else if (routeOrientation == RouteOrientation.HORIZONTAL) {
            when (drawingRouteShape) {
                RouteShape.LEFT -> canvas.drawLine(
                    width / 2.0f,
                    height / 2.0f,
                    width.toFloat(),
                    height / 2.0f,
                    paint
                )
                RouteShape.MIDDLE -> canvas.drawLine(
                    0f,
                    height / 2.0f,
                    width.toFloat(),
                    height / 2.0f,
                    paint
                )
                RouteShape.RIGHT -> canvas.drawLine(
                    0f,
                    height / 2.0f,
                    width / 2.0f,
                    height / 2.0f,
                    paint
                )
                else -> return
            }
        }
    }

    override fun onRtlPropertiesChanged(layoutDirection: Int) {
        super.onRtlPropertiesChanged(layoutDirection)
        updateLayoutDirection()
    }

    private fun updateLayoutDirection() {
        drawingRouteShape = routeShape

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1
            && routeOrientation == RouteOrientation.HORIZONTAL
        ) {
            if (routeShape == RouteShape.START) {
                drawingRouteShape = if (layoutDirection == LAYOUT_DIRECTION_RTL) {
                    RouteShape.RIGHT
                } else {
                    RouteShape.LEFT
                }
            } else if (routeShape == RouteShape.END) {
                drawingRouteShape = if (layoutDirection == LAYOUT_DIRECTION_RTL) {
                    RouteShape.LEFT
                } else {
                    RouteShape.RIGHT
                }
            }
        } else {
            if (routeShape == RouteShape.START) {
                drawingRouteShape = RouteShape.LEFT
            } else if (routeShape == RouteShape.END) {
                drawingRouteShape = RouteShape.RIGHT
            }
        }

        invalidate()
    }

    companion object {
        private val THREE_DP = 3.dp
        private val FOUR_DP = 4.dp
    }
}
