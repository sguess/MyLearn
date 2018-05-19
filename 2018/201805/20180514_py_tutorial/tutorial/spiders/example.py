# -*- coding: utf-8 -*-
import scrapy


class ExampleSpider(scrapy.Spider):
    name = 'example'
    allowed_domains = ['www.hao123.com']
    start_urls = ['http://www.hao123.com/']

    def parse(self, response):
        pass
