# Condomínio ACME

## EndPoints

<h3>Já existe na base os condomínios 1 e 2</h3>



1 - Criação da Unidade, com o responsável e o condomínio

<i>POST http://localhost:8081/unidades</i>  

```
{
	"numero":"2",
	"bloco": "bloco 1",
	"responsavel":{
		"nome": "Jorge",
		"email": "jorge@gmail.com",
		"telefone": "99898-9898"
	}
	,"condominioId":1
}
```


2 - Enviar multa para unidade

<i>POST http://localhost:8081/multas</i>  

```
{

			"descricao":"multa por desordem",
			"data": "2020-01-02",
			"valor": 100,
			"unidadeId":2
}
```


3 - Enviar aviso para unidade

<i>POST http://localhost:8081/avisos</i>  

```
{

			"descricao":"Aviso de som",
			"unidadeId":2
}
```


4 - Apresentar as unidades com multas

<i>GET http://localhost:8081/unidades/com-multas</i>  


5 - Apresentar as unidades sem multas

<i>GET http://localhost:8081/unidades/sem-multas</i>  


