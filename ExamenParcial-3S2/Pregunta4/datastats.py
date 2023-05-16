import math
import json

class NDataStats:
    def _salario_promedio(self, data):
        return math.floor(sum([int(e['salario'][1:]) for e in data])/len(data))
    def _edades(self):
        return [d['edad'] for d in self.data]
    def stats(self, data, iedad, isalario):
        nds = NDataStats(data)
        return nds.stats(iedad, isalario)
