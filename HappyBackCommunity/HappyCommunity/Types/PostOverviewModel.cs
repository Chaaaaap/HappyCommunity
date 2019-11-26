using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HappyCommunity.Types
{
	public class PostOverviewModel
	{
        public long Id { get; set; }
        public string Title { get; set; }
        public int Reward { get; set; }
        public string Name { get; set; }
		public string City { get; set; }
		public string UserName { get; set; }

	}
}
