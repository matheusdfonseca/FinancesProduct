package br.com.finances.product.controller.config

import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

fun getURILocation(path: String, args: Map<String, Any>): URI =
    ServletUriComponentsBuilder.fromCurrentRequest()
        .path(path)
        .buildAndExpand(args)
        .toUri()