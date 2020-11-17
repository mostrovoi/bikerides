package com.acme

import com.acme.summary.IndexData
import com.acme.summary.SummaryPresentator
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class BikeRidesController {

    companion object {
        val rides = IndexData(items = SummaryPresentator.readAllRides())
    }

    @GetMapping("/")
    fun showBikeRides(model: Model) : String {

        model.addAttribute("bikerides", rides)
        return "bikerides"
    }
}