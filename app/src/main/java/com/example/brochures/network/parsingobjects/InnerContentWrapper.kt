package com.example.brochures.network.parsingobjects

import com.example.brochures.network.SingleToArray
import com.squareup.moshi.Json

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */
class InnerContentWrapper {

    @SingleToArray
    val innerContent: List<InnerContent>? = null
}