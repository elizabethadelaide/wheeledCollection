# some_app/views.py
from django.views.generic import TemplateView

class GraphView(TemplateView):
    template_name = "graph.html"

#TODO: Add functions here
#function getFFT of whatever data from dropdown

#function getPeaks of whatever data from dropdown

#function getFullJSON data with coordinates
