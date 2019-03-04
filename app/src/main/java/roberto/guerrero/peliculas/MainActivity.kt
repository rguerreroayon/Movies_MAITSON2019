package roberto.guerrero.peliculas

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.peliculas_view.view.*

class MainActivity : AppCompatActivity() {
    var listaPeliculas = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        crearPeliculas()
        var adaptador = AdaptadorPelicula(this,listaPeliculas)
        listView.adapter = adaptador

    }

    fun crearPeliculas(){
        var pel1 = Pelicula(nombre = "Captain Marvel", descripcion = "HOLA",imagen = R.drawable.captain)
        var pel2 = Pelicula(nombre = "Gloria Bell", descripcion = "HOLA",imagen = R.drawable.gloria)
        var pel3 = Pelicula(nombre = "The Sex Trip", descripcion = "HOLA",imagen = R.drawable.sex)
        var pel4 = Pelicula(nombre = "The Kid", descripcion = "HOLA",imagen = R.drawable.kid)
        var pel5 = Pelicula(nombre = "Alita", descripcion = "HOLA",imagen = R.drawable.alita)
        var pel6 = Pelicula(nombre = "Lego Movie 2", descripcion = "HOLA",imagen = R.drawable.lego)
        var pel7 = Pelicula(nombre = "ISN'T IT ROMANTIC", descripcion = "HOLA",imagen = R.drawable.romantic)
        var pel8 = Pelicula(nombre = "What men want", descripcion = "HOLA",imagen = R.drawable.men)


        listaPeliculas?.add(pel1)
        listaPeliculas?.add(pel2)
        listaPeliculas?.add(pel3)
        listaPeliculas?.add(pel4)
        listaPeliculas?.add(pel5)
        listaPeliculas?.add(pel6)
        listaPeliculas?.add(pel7)
        listaPeliculas?.add(pel8)
    }

    private class AdaptadorPelicula : BaseAdapter {
        var context: Context? = null
        var peliculas: ArrayList<Pelicula>? = null
        constructor(context:Context,peliculas:ArrayList<Pelicula>){
            this.context = context
            this.peliculas = peliculas
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var layout = LayoutInflater.from(context)
            var vista = layout?.inflate(R.layout.peliculas_view,null)!!
            var pel = peliculas!![position]
            if(vista != null){
                vista.tv_nombre.text = pel.nombre
                vista.imageView.setImageResource(pel.imagen)
            }

            return vista
        }

        override fun getItem(position: Int): Any {
            return peliculas?.get(position) ?: "Error"

        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return peliculas?.size ?: 0
        }


    }


}
