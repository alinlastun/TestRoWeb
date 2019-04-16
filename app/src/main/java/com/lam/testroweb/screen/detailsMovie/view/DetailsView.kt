package com.lam.testroweb.screen.detailsMovie.view

import com.lam.testroweb.model.DetailsMovie

interface DetailsView {
        fun getSuccessData(detailsModel: DetailsMovie)
        fun getErrorData(strError: String)

}
