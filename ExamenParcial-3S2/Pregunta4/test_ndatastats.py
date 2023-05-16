import json

from datastats import NDataStats
test_data = [
    {
          "id": 1,
          "nombre": "Irene",
          "apodo": "Lara",
          "edad": 68,
          "salario": "$27888" 
        },
       
       {
           "id": 2,
          "nombre": "Claudio",
          "apodo": "Avila",
          "edad": 49,
          "salario": "$67137"
      },
      {
          "id": 3,
          "nombre": "Tomo",
          "apodo": "Frugs",
          "edad": 70,
          "salario": "$70472"
      }
    
]

def test_init():
    ds = NDataStats(test_data)
    assert ds.data == test_data


def test__salario_promedio():
    ds = NDataStats()
    assert ds._salario_promedio(test_data) == 55165

def test_edad():
    ds = NDataStats()
    assert ds._edades() == [68, 49, 70]

def test__stats():

   ds = NDataStats()
   
   assert ds.stats(test_data, 20, 20000) == {
        "edad_promedio": 62,
        "salario_promedio": 55165,
        "incremento_anual_promedio": 837,
        "max_salario": [{
            "id": 3,
            "nombre": "Tomo",
            "apodo": "Frugs",
             "edad": 70,
              "salario": "$70472"
    }],
    "min_salario": [{
        "id": 1,
        "nombre": "Irene",
        "apodo": "Lara",
        "edad": 68,
        "salario": "$27888"
        
        }]
    }
